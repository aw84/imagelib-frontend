function imageBigView(img) {
    $.ajax({
        url: "/fragments/imageOverlay?p=" + img.id,
        success: function (result) {
            console.log(result);
            $('#imageOverlay').html(result);
        }
    });
    $('#imageOverlay').click(function () { $('#imageOverlay').html("<div></div>"); $(this).dialog("close"); });
    $('#imageOverlay').dialog({
        position: { my: "top", at: "top", of: window },
        dialogClass: "no-close",
        modal: true,
        minWidth: 700,
        iframe: true,
    });
}
function uploadPopup() {
    $.ajax({
        url: "/fragments/uploadOverlay",
        success: function (result) {
            console.log(result);
            console.log($('#uploadOverlay'));
            if ($('#uploadOverlay').length === 0) {
                var element = $("<div />");
                element.html(result);
                element.appendTo($("body"));
            } else {
                $('#uploadOverlay').html(result);
            }
            $('#uploadOverlay').dialog({
                position: { my: "top", at: "top", of: window },
                dialogClass: "no-close",
                modal: true,
                minWidth: 700,
                iframe: true,
            });
        }
    });
}
function uploadOkButton() {
    // console.log(this);
    fileName = $('#uploadImageFile')[0].files;
    console.log(fileName);
    $('#uploadOverlay').dialog("close");
}