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