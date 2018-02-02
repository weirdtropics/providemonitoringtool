$(document).ready(function() {


    var previousCriticalCount = 0;

    function soundWarning() {
        var audio = new Audio();
        audio.src = 'https://www.soundjay.com/button/beep-07.mp3';
        audio.autoplay = true;

    }

    $("#frm").on("submit", function(event) {

        event.preventDefault();

        $.ajax({
            url: "/monitor/add",
            type: "post",
            data: JSON.stringify({
                'url': $('input[name=url]').val(),
        'exceptedHttpResponseCode': $('input[name=exceptedHttpResponseCode]').val(),
            'expectedResponseSizeFrom': $('input[name=expectedResponseSizeFrom]').val(),
            'expectedResponseSizeTo': $('input[name=expectedResponseSizeTo]').val()
        }),
            contentType: "application/json",
            success: refreshTable,
        });

    });

    $('#mydata').on('click','button.delBtn',function(){
        var id = $(this).data('id');

        $.ajax({
            url: '/monitor/delete/' +$(this).data('id'),
        type: 'DELETE',
        dataType: "json",
        success: refreshTable()
     });

    });


    $('#mydata').on('click', 'button.activeBtn', function() {
        var $t = $(this);
        $.ajax({
            url: '/monitor/' + $t.parents('tr').attr('class') + '/' + $t.data('id'),
        type: 'POST',
        dataType: "json",
        success: refreshTable()


    });

    });


    function refreshTable() {
            $.ajax({

                url: "monitor/all",
            type: "GET",
            dataType: "json",
            success: function(response) {
                var trHTML = '',count = 0;

                $.each(response, function(key, value) {
                    if(value.status == "CRITICAL") count++;
                    trHTML += '<tr class="' + ((value.active? 'de' : '') + 'active') + '"><td>' +
                        value.id + '</td><td><a href="'+value.url+'">' + value.url + '</a></td><td>' +
                        value.exceptedHttpResponseCode + '</td><td>' +
                        value.status + '</td><td><button data-id="' + value.id + '" + ' +
                        'value.id + class="btn btn-danger btn-sm delBtn">Delete</td>' +
                        '<td>' +
                    '<button data-id="'+value.id+'" class="btn btn-'+(value.active?'danger':'success')+' btn-sm activeBtn">' +
                    (value.active?'Dea':'A')+'ctivate' +
                    '</button>' +
                    '</td>' +
                    '</tr>';

                });

                $('#mydata').html(trHTML);

                if(count > previousCriticalCount) soundWarning();
                previousCriticalCount = count;
            }

        });

        };

    setInterval(function(){
        console.log("Updating monitors")
        refreshTable();
    }, 2000);
});



