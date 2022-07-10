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

    var formData = new FormData();
    jQuery.each($('#uploadImageFile')[0].files, function (i, file) {
        formData.append('files', file);
    });
    console.log($('#uploadImageFile')[0].files);
    file = $('#uploadImageFile')[0].files[0];
    // console.log("File: " + file);
    // var formData = new FormData();
    // formData.append("files", file);
    $.ajax({
        url: "/upload?fname=" + file.name,
        type: "POST",
        method: "POST",
        cache: false,
        data: formData,
        processData: false,
        contentType: false,
        success: function (result) {
            console.log("Upload result: " + result);
        }
    });

    $('#uploadOverlay').dialog("close");
}