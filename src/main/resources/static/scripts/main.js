function imageBigView(img) {
    $('#imageOverlay').html("<img id='image' src='" + img.src + "'/>");
    $('#imageOverlay').click(function () { $(this).dialog("close"); });
    $('#imageOverlay').dialog({
        dialogClass: "no-close",
        modal: true,
        minWidth: 700,
    });
}