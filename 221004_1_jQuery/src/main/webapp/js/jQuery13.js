$(() => {
    $('.delete').click(function() {
        $(this).parent().slideUp(1000, 'easeInOutBounce');
    });

    $('#view').click(function() {
        $('.pane').slideDown('slow');
    });
})