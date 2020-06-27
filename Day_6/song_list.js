let cnt = 0;

const songList = [{
    name: "",
    singers: "",
    songId: ""
}];

function getSongListJson() {
    const test = {
        "code" : 0,
        "msg" : "",
        "count" : 10,
        "data" : [{
            "singers": "Marshmello",
            "name": "Alone",
            "songId": "412785957"
        }, {
            "singers": "Selena Gomez / Marshmello",
            "name": "Wolves",
            "songId": "515269424"
        }, {
            "singers": "Marshmello / Bastille",
            "name": "Happier",
            "songId": "1302290019"
        }, {
            "singers": "Marshmello / Halsey",
            "name": "Be Kind",
            "songId": "1444959394"
        }, {
            "singers": "Marshmello / Anne-Marie",
            "name": "FRIENDS",
            "songId": "535024262"
        }, {
            "singers": "英雄联盟 / Marshmello",
            "name": "Flash Funk (Marshmello Remix)",
            "songId": "400161903"
        }, {
            "singers": "Marshmello / Khalid",
            "name": "Silence",
            "songId": "497218032"
        }, {
            "singers": "Marshmello / Leau Culver",
            "name": "Fly",
            "songId": "543988435"
        }, {
            "singers": "Marshmello / Anne-Marie",
            "name": "FRIENDS",
            "songId": "1352932037"
        }, {
            "singers": "Migos / Marshmello",
            "name": "Danger",
            "songId": "522529654"
        }]
    };

    return JSON.parse(JSON.stringify(test));
}

layui.use('table', function () {
    const table = layui.table;

    // test
    table.render({
        elem: "#demo",
        height: 315,
        url: getSongListJson(),
        cols : [[
            {
                field : 'name',
                title : '歌曲名'
            },
            {
                field : 'singers',
                title : '歌手'
            },
            {
                field : 'songId',
                title : '歌曲id'
            }
        ]]
    });
})
