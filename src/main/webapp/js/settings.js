/**
 * Created by Михаил on 17.12.2016.
 */

$(document).ready(function () {
    $("#add_expedition_form").each(function () {

        var form = $(this);

        function addClassEmptyIfNoValue() {
            form.find(".input_green").each(function () {
                if ($(this).val() != '') {
                    $(this).removeClass("empty-field")
                } else {
                    $(this).addClass("empty-field")
                }
            });
        }

        function lightEmpty(interval) {
            var emptyFields = form.find('.empty-field');

            lightField(emptyFields, interval)
        }

        function lightField(field, interval) {
            field.css({
                'border-color': 'red',
                'border-width': '1px',
                'box-shadow': 'inset 0px 0px 5px rgba(100, 0, 0, 70)'
            });

            setTimeout(function () {
                field.removeAttr('style')
            }, interval)
        }

        form.submit(function () {

            addClassEmptyIfNoValue();
            var countOfEmptyFields = form.find('.empty-field').size();

            if (countOfEmptyFields > 0) {
                lightEmpty(600)
            } else {

                $.ajax({
                    url: "/settings",
                    type: "POST",
                    data: {
                        "name": $('input[name=name]').val(),

                    }
                }).done(function (data) {
                    if (data == "success") {
                        form.html("Успешно!");

                        setTimeout(function () {
                            location.href = "/"
                        }, 500);

                    } else {
                        var message = JSON.parse(data);
                        alert(message[0]);
                    }
                });
            }

            return false
        })
    })
});

