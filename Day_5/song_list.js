let cnt = 0;

const songList = [{
    name : "",
    singers : "",
    songId : ""
}];

function getSongList() {
    const jsonArr = document.getElementById("searchResult").parseJSON();

    const ul = $("<ul></ul>");
    for (let i = 0; i < jsonArr.length; i++) {
        ul.append("<li>" + jsonArr[i].name + " " + jsonArr[i].singers + "</li>");
    }
    $("#searchResult").append(ul);

}