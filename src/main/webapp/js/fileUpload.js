/**
 * Created by apple on 20.12.16.
 */

$('#image_load_form').submit(function() {
    var file = this.elements.myfile.files[0];
    if (file) {
        upload(file, $(this).action);
    }
    return false;
});


function upload(file, url) {

    var xhr = new XMLHttpRequest();

    // обработчики можно объединить в один,
    // если status == 200, то это успех, иначе ошибка
    xhr.onload = xhr.onerror = function() {
        if (this.status == 200) {
            console.log("success");
        } else {
            console.log("error " + this.status);
        }
    };

    // обработчик для закачки
    xhr.upload.onprogress = function(event) {
        console.log(event.loaded + ' / ' + event.total);
    };

    xhr.open("POST", url, true);
    xhr.send(file);

}