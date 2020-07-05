package com.cr.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetSongInfos {
    /**
     * 步骤：先从api获得json，将json转为json对象
     * 然后使用getString获得key对应的value
     * 一层层剥下去，最终获得想要的信息
     */
    public List<String[]> getSearchResult(String info) throws IOException {
        OkHttpApi api = new OkHttpApi();
        // 拼接得到搜索 api 信息
        String str = "https://api.itooi.cn/netease/search?keyword=" + info + "&type=song&pageSize=10&page=0";
        // 获得搜索结果
        String res = api.run(str);
        // 首先转为一个大的JSONObject
        JSONObject object = JSONObject.parseObject(res);
        // 剥离出歌曲信息，一共十首，每首的有对应的 id
        JSONArray songs = JSONObject.parseObject(object.getString("data")).getJSONArray("songs");
        List<String[]> songDetails = new ArrayList<>();
        for (Object song : songs) {
            JSONObject obj = JSONObject.parseObject(song.toString());
            // 由于歌手可能有多个，所以需要单独拿出来解析
            String singers = obj.getString("ar");
            JSONArray temp = JSONArray.parseArray(singers);
            StringBuilder singerInfo = new StringBuilder();
            int len = temp.size();
            for (int i = 0; i < len; i++) {
                if (i > 0) {
                    singerInfo.append(" / ");
                }
                singerInfo.append(JSONObject.parseObject(temp.get(i).toString()).getString("name"));
            }
            String songName = obj.getString("name");
            String songId = obj.getString("id");
            songDetails.add(new String[]{ songName, singerInfo.toString(), songId });
        }

        return songDetails;
    }

    public static void main(String[] args) throws IOException {
        OkHttpApi api = new OkHttpApi();
        // 从 api 获得十首搜索关键字相关的歌曲 Json 信息
        // api 地址：https://api.itooi.cn/netease/search?keyword=搜索框内的值&type=song&pageSize=10&page=0
        String str = api.run("https://api.itooi.cn/netease/lrc?id=28737747");
        // 首先转为一个大的JSONObject
        String[] res = str.split("\\[");
        for (String s : res) {
            System.out.println(s.trim());
        }
        String pattern = "\\[\\d{2}:\\d{2}\\.\\d{2}]";
        System.out.println("[00:00.000]".matches(pattern));

//        JSONObject object = JSONObject.parseObject(str);
        // 剥离出歌曲信息，一共十首，每首的有对应的 id
//        JSONArray songs = JSONObject.parseObject(object.getString("data")).getJSONArray("songs");
//        List<String> songsId = new ArrayList<>();
//        for (Object song : songs) {
//            songsId.add(JSONObject.parseObject(song.toString()).getString("id"));
//        }

        // 获得歌曲的 id 信息后
        // 生成 api 的播放链接替换到主页中的 audio 标签里
        // 所以现在有两个问题，一是后端 Java 怎么去影响前端
        // 二是放到 audio 标签中后，当一首歌播放完了
        // 是怎么知道它真的播放完了，如何触发在线歌单换歌
//        System.out.println(songsId);

        // 解决了上面的搜歌和播放问题，那么我们要解决的就是
        // 通过 id 获得歌曲详细信息，解析歌曲名、歌手和歌词
        // 并将其显示在页面上
        // 到时候的用户 —— 我的收藏，收藏的条例就是
        // 歌曲名、歌手、以及歌曲id，可以自行复制 id 去
        // 网易云音乐搜索这首歌
        System.out.println("Hello!");
    }
}
