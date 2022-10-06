$(() => {

    $('.run').click(() => {
        $('#box').animate(
            {
                'left': '400px',
                'opacity': 0.1
            },
            1000,
            'swing'
        ).animate(
            {
                'top': '350px',
                'opacity': 0.6,
                'width': '200px',
                'height': '200px'
            },
            1000,
            'swing'
        ).animate(
            {
                'left': '0px',
                'opacity': 0.3
            },
            1000,
            'swing'
        ).animate(
            {
                'top': '0px',
                'opacity': 1.0
            },
            1000,
            'swing'
        ).slideUp(1000);
    })

})