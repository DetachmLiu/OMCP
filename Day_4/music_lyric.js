const currentSong = {
    songName : "",
    songId : "412785957",
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
    })
}

let lyricInfo = [];
function parseLyric(lyrics) {
    const pattern = /\d{2}:\d{2}\.\d{2}/g;
    // 根据 '[' 来分割每一句歌词
    let lyricData = lyrics.split("[");

    // 遍历 lyricData，分割时间戳和歌词信息
    // 歌词首部加个空白行用来显示
    lyricInfo.push({
        time : 0,
        lyric : ""
    });
    // 跳过下标 0 的空字符串
    for (let i = 1; i < lyricData.length; i++) {
        const line = lyricData[i].split("]");
        // 如果 "[]" 内的信息不是时间，那就跳过这一句
        if (line[0].match(pattern) === null) {
            continue;
        }
        const m = line[0].substr(0, 2);
        const s = line[0].substr(3, 2);
        const times = m * 60 + s;
        // 遇到了后一句歌词时间在前一句歌词之前，
        // 这种情况会出现在外语歌中，翻译在前半段，
        // 原文在后半段，此时清空 lyricInfo，
        // 用于记录原文
        if (lyricInfo.pop().time > times) {
            lyricInfo = [];
            lyricInfo.push({
                time : 0,
                lyric : ""
            });
        }
        lyricInfo.push({
            time : times,
            lyric : line[1]
        });
        if (i === lyricData.length - 1) {
            // 歌词尾部增加空白行便于显示
            lyricInfo.push({
                time : times + 1,
                lyric : ""
            })
        }
    }
}

// 插入到主页的 html 中去
$("#player").addEventListener("timeupdate", function () {
    const index = lyricInfo.findIndex(item => {
        return item.time >= this.currentTime;
    })
    const html = `
        <li>${lyricInfo[index - 1].lyric}</li>
        <li>${lyricInfo[index].lyric}</li>
        <li>${lyricInfo[index + 1].lyric}</li>
    `;

    return $(".lyric").innerHTML = html;
})