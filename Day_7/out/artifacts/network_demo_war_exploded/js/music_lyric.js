const currentSong = {
    songName : "",
    songId : "557601772",
    singers : "",
    lyricUrl : "https://api.itooi.cn/netease/lrc?id=",
    picUrl : "https://api.itooi.cn/netease/pic?id="
};

function getLyric() {
    $.ajax({
        url: currentSong.lyricUrl + currentSong.songId,
        type: "get",
        dataType: "text",
        success: parseLyric,
        error: function () {
            alert("Laji");
        }
    })
}

let lyricInfo = [];
function parseLyric(lyrics) {
    const pattern = /\d{2}:\d{2}\.\d{2}/g;
    // 根据 '[' 来分割每一句歌词
    let lyricData = lyrics.split("[");

    // 遍历 lyricData，分割时间戳和歌词信息
    // 跳过下标 0 的空字符串
    lyricInfo.push({
        time : -1,
        lyric : "&nbsp"
    })
    for (let i = 1; i < lyricData.length; i++) {
        const line = lyricData[i].split("]");
        // 如果 "[]" 内的信息不是时间，那就跳过这一句
        if (line[0].match(pattern) === null) {
            continue;
        }
        const m = line[0].substr(0, 2);
        const s = line[0].substr(3, 2);
        const ms = line[0].substr(6, 2);
        const times = parseInt(m) * 60 + parseInt(s) + parseInt(ms) * 0.01;
        // 遇到了后一句歌词时间在前一句歌词之前，
        // 这种情况会出现在外语歌中，翻译在前半段，
        // 原文在后半段，此时清空 lyricInfo，
        // 用于记录原文
        if (lyricInfo[lyricInfo.length - 1].time > times) {
            lyricInfo = [];
            lyricInfo.push({
                time : -1,
                lyric : "&nbsp"
            })
        }
        lyricInfo.push({
            time : times,
            lyric : line[1].trim()
        });
        if (i === lyricData.length - 1) {
            lyricInfo.push({
                time : times + 1,
                lyric : ""
            })
        }
    }
}

// 插入到主页的 html 中去
// function addLyric() {
//     const ul = $("<ul></ul>");
//     for (let i = 0; i < lyricInfo.length; i++) {
//         ul.append("<li>" + lyricInfo[i].lyric + "</li>");
//     }
//     $("#lyrics").append(ul);
// }

window.onload = function() {
    document.getElementById("player").addEventListener("timeupdate", function () {
        const index = lyricInfo.findIndex(item => {
            return item.time >= this.currentTime;
        });
        if (index < 0) {
            return;
        }

        if (index < 2) {
            document.getElementById("lyrics").innerHTML = `
                <li style="font-size: 40px; color: red;text-align: center">
                        ${lyricInfo[index - 1].lyric || "&nbsp"}
                </li>
                <li style="font-size: 30px;color: #c81cae;text-align: center">${lyricInfo[index].lyric}</li>
                <li style="font-size: 30px;color: #c81cae;text-align: center">${lyricInfo[index + 1].lyric}</li>
            `;
            return;
        }

        document.getElementById("lyrics").innerHTML = `
            <li style="font-size: 30px;color: #c81cae;text-align: center">${lyricInfo[index - 2].lyric}</li>
            <li style="font-size: 40px; color: red;text-align: center">
                    ${lyricInfo[index - 1].lyric}
            </li>
            <li style="font-size: 30px;color: #c81cae;text-align: center">${lyricInfo[index].lyric}</li>
        `;
    })
}
// window.onload = function() {
//
//     document.getElementById("player").addEventListener("timeupdate", function () {
//         const index = lyricInfo.findIndex(item => {
//             return item.time >= this.currentTime;
//         });
//         document.getElementById("lyrics").innerHTML = `
//         <li style="font-size: 40px;color: #03fbb8"><b>${lyricInfo[index - 1].lyric}</b></li>
//         <li style="font-size: 33px;color: #c81cae">${lyricInfo[index].lyric}</li>
//         <li style="font-size: 33px;color: #c81cae">${lyricInfo[index + 1].lyric}</li>
//     `;
//     })
// }
