package com.minglemingle.chat2mingle.aspect.transaction;

import oracle.jdbc.OracleDatabaseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.lang.reflect.Method;
import java.sql.SQLException;

@Component
@Aspect
public class TransactionAspect {
    private final PlatformTransactionManager transactionManager;
    Logger log = LogManager.getLogger("transaction");

    public TransactionAspect(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Pointcut(value = "@annotation(com.minglemingle.chat2mingle.aspect.transaction.annotation.Transactional)")
    public void transactionalMethod() {
    }

    @Around("transactionalMethod()")
    public Object aroundTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

        TransactionStatus txStatus =
                transactionManager.getTransaction(new DefaultTransactionDefinition());

        Object result = null;

        try {
            result = joinPoint.proceed();
            transactionManager.commit(txStatus);
        }
        catch (Exception e) {
            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            Throwable cause = e.getCause();
            String error_msg = "========================================="
                    + "Method: " + method + "\n"
                    + "Cause: " + cause;

            if (cause instanceof SQLException) {
                SQLException sqlException = (SQLException) cause;
                OracleDatabaseException oracleDatabaseException = (OracleDatabaseException) sqlException.getCause();
                error_msg += "Error Msg: " + oracleDatabaseException.getMessage()
                        + "SQL Error Code: " + sqlException.getErrorCode()
                        + "SQL: " + oracleDatabaseException.getSql();
            }
            else {
                error_msg += "Error Msg" + e.getMessage()
                        + "Error Class" + e.getClass().getName();
            }
            log.error(error_msg);
            transactionManager.rollback(txStatus);
        }
        return result;
    }
}
