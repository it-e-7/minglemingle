  var modal = document.getElementById("myModal");
  var confirmButton = document.getElementById("confirmButton");
  var cancelButton = document.getElementById("cancelButton");

  function openModal(reporter, reportee) {
    modal.style.display = "block";

    confirmButton.onclick = function() {
      closeModal();
      report(reporter, reportee);
    }

    cancelButton.onclick = function() {
      closeModal();
    }
  }

  function closeModal() {
    modal.style.display = "none";
  }

function removeReportFromList(reporter, reportee) {
  var reportRows = document.getElementsByClassName("report-tr");

  for (var i = 0; i < reportRows.length; i++) {
    var reporterCell = reportRows[i].getElementsByClassName("reporter-nickname")[0];
    var reporteeCell = reportRows[i].getElementsByClassName("reportee-nickname")[0];

    if (reporterCell.textContent === reporter && reporteeCell.textContent === reportee) {
      reportRows[i].remove();
      break;
    }
  }
}

  function report(reporter, reportee) {
    // 여기에 해당 버튼 클릭 시 수행할 동작을 추가하세요
    removeReportFromList(reporter, reportee);
    alert(reporter + "님이 " + reportee + "님을 신고했습니다.");
  }