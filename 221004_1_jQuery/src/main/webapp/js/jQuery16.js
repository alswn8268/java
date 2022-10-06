$(() => {
    $('#shuffle').cycle({ 
        fx:     'shuffle', 
        easing: 'easeOutBack', 
        delay:  -4000 
    });
    $('#right').cycle({ 
        fx:      'scrollRight', 
        next:   '#right', 
        timeout:  0, 
        easing:  'easeInOutBack' 
    });
})