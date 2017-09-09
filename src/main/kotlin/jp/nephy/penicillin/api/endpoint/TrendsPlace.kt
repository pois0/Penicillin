package jp.nephy.penicillin.api.endpoint

import com.github.salomonbrys.kotson.*
import com.google.gson.JsonElement
import jp.nephy.penicillin.api.AbsOAuthGet
import jp.nephy.penicillin.api.Parameter
import jp.nephy.penicillin.api.ResponseFormats
import jp.nephy.penicillin.request.handler.OAuthRequestHandler

class TrendsPlaceModel(val json: JsonElement) {
    val asOf by json.byNullableString("as_of") // "2017-09-09T08:47:26Z"
    val createdAt by json.byNullableString("created_at") // "2017-09-09T08:43:56Z"
    val locations by json.byNullableArray // [{"name": "Japan", "woeid": 23424856}]
    val trends by json.byNullableArray // [{"name": "日本人初の9秒台", "url": "http://twitter.com/search?q=%E6%97%A5%E6%9C%AC%E4%BA%BA%E5%88%9D%E3%81%AE9%E7%A7%92%E5%8F%B0", "promoted_content": null, "query": "%E6%97%A5%E6%9C%AC%E4%BA%BA%E5%88%9D%E3%81%AE9%E7%A7%92%E5%8F%B0", "tweet_volume": 39461}, {"name": "桐生選手", "url": "http://twitter.com/search?q=%E6%A1%90%E7%94%9F%E9%81%B8%E6%89%8B", "promoted_content": null, "query": "%E6%A1%90%E7%94%9F%E9%81%B8%E6%89%8B", "tweet_volume": 34178}, {"name": "桐生くん", "url": "http://twitter.com/search?q=%E6%A1%90%E7%94%9F%E3%81%8F%E3%82%93", "promoted_content": null, "query": "%E6%A1%90%E7%94%9F%E3%81%8F%E3%82%93", "tweet_volume": null}, {"name": "ナゲット", "url": "http://twitter.com/search?q=%E3%83%8A%E3%82%B2%E3%83%83%E3%83%88", "promoted_content": null, "query": "%E3%83%8A%E3%82%B2%E3%83%83%E3%83%88", "tweet_volume": 32172}, {"name": "#pixivMEETUP", "url": "http://twitter.com/search?q=%23pixivMEETUP", "promoted_content": null, "query": "%23pixivMEETUP", "tweet_volume": null}, {"name": "+1.8", "url": "http://twitter.com/search?q=%2B1.8", "promoted_content": null, "query": "%2B1.8", "tweet_volume": 1461458}, {"name": "#heroaca_a", "url": "http://twitter.com/search?q=%23heroaca_a", "promoted_content": null, "query": "%23heroaca_a", "tweet_volume": null}, {"name": "桐生さん", "url": "http://twitter.com/search?q=%E6%A1%90%E7%94%9F%E3%81%95%E3%82%93", "promoted_content": null, "query": "%E6%A1%90%E7%94%9F%E3%81%95%E3%82%93", "tweet_volume": 12326}, {"name": "すわほー", "url": "http://twitter.com/search?q=%E3%81%99%E3%82%8F%E3%81%BB%E3%83%BC", "promoted_content": null, "query": "%E3%81%99%E3%82%8F%E3%81%BB%E3%83%BC", "tweet_volume": null}, {"name": "配布SSR", "url": "http://twitter.com/search?q=%E9%85%8D%E5%B8%83SSR", "promoted_content": null, "query": "%E9%85%8D%E5%B8%83SSR", "tweet_volume": 14209}, {"name": "#aniaca", "url": "http://twitter.com/search?q=%23aniaca", "promoted_content": null, "query": "%23aniaca", "tweet_volume": null}, {"name": "#scala_ks", "url": "http://twitter.com/search?q=%23scala_ks", "promoted_content": null, "query": "%23scala_ks", "tweet_volume": null}, {"name": "山田哲人", "url": "http://twitter.com/search?q=%E5%B1%B1%E7%94%B0%E5%93%B2%E4%BA%BA", "promoted_content": null, "query": "%E5%B1%B1%E7%94%B0%E5%93%B2%E4%BA%BA", "tweet_volume": null}, {"name": "パワスト", "url": "http://twitter.com/search?q=%E3%83%91%E3%83%AF%E3%82%B9%E3%83%88", "promoted_content": null, "query": "%E3%83%91%E3%83%AF%E3%82%B9%E3%83%88", "tweet_volume": null}, {"name": "ミステリーゾーン", "url": "http://twitter.com/search?q=%E3%83%9F%E3%82%B9%E3%83%86%E3%83%AA%E3%83%BC%E3%82%BE%E3%83%BC%E3%83%B3", "promoted_content": null, "query": "%E3%83%9F%E3%82%B9%E3%83%86%E3%83%AA%E3%83%BC%E3%82%BE%E3%83%BC%E3%83%B3", "tweet_volume": null}, {"name": "#アーカイブサミット", "url": "http://twitter.com/search?q=%23%E3%82%A2%E3%83%BC%E3%82%AB%E3%82%A4%E3%83%96%E3%82%B5%E3%83%9F%E3%83%83%E3%83%88", "promoted_content": null, "query": "%23%E3%82%A2%E3%83%BC%E3%82%AB%E3%82%A4%E3%83%96%E3%82%B5%E3%83%9F%E3%83%83%E3%83%88", "tweet_volume": null}, {"name": "D-05", "url": "http://twitter.com/search?q=D-05", "promoted_content": null, "query": "D-05", "tweet_volume": null}, {"name": "ディアドラ", "url": "http://twitter.com/search?q=%E3%83%87%E3%82%A3%E3%82%A2%E3%83%89%E3%83%A9", "promoted_content": null, "query": "%E3%83%87%E3%82%A3%E3%82%A2%E3%83%89%E3%83%A9", "tweet_volume": null}, {"name": "ニュース速報", "url": "http://twitter.com/search?q=%E3%83%8B%E3%83%A5%E3%83%BC%E3%82%B9%E9%80%9F%E5%A0%B1", "promoted_content": null, "query": "%E3%83%8B%E3%83%A5%E3%83%BC%E3%82%B9%E9%80%9F%E5%A0%B1", "tweet_volume": 17462}, {"name": "ゲレーロ", "url": "http://twitter.com/search?q=%E3%82%B2%E3%83%AC%E3%83%BC%E3%83%AD", "promoted_content": null, "query": "%E3%82%B2%E3%83%AC%E3%83%BC%E3%83%AD", "tweet_volume": null}, {"name": "リビジョン", "url": "http://twitter.com/search?q=%E3%83%AA%E3%83%93%E3%82%B8%E3%83%A7%E3%83%B3", "promoted_content": null, "query": "%E3%83%AA%E3%83%93%E3%82%B8%E3%83%A7%E3%83%B3", "tweet_volume": null}, {"name": "コンサドーレ", "url": "http://twitter.com/search?q=%E3%82%B3%E3%83%B3%E3%82%B5%E3%83%89%E3%83%BC%E3%83%AC", "promoted_content": null, "query": "%E3%82%B3%E3%83%B3%E3%82%B5%E3%83%89%E3%83%BC%E3%83%AC", "tweet_volume": null}, {"name": "第4試合", "url": "http://twitter.com/search?q=%E7%AC%AC4%E8%A9%A6%E5%90%88", "promoted_content": null, "query": "%E7%AC%AC4%E8%A9%A6%E5%90%88", "tweet_volume": null}, {"name": "追い風参考", "url": "http://twitter.com/search?q=%E8%BF%BD%E3%81%84%E9%A2%A8%E5%8F%82%E8%80%83", "promoted_content": null, "query": "%E8%BF%BD%E3%81%84%E9%A2%A8%E5%8F%82%E8%80%83", "tweet_volume": null}, {"name": "紫苑ステークス", "url": "http://twitter.com/search?q=%E7%B4%AB%E8%8B%91%E3%82%B9%E3%83%86%E3%83%BC%E3%82%AF%E3%82%B9", "promoted_content": null, "query": "%E7%B4%AB%E8%8B%91%E3%82%B9%E3%83%86%E3%83%BC%E3%82%AF%E3%82%B9", "tweet_volume": null}, {"name": "西山宏太朗の健やか", "url": "http://twitter.com/search?q=%E8%A5%BF%E5%B1%B1%E5%AE%8F%E5%A4%AA%E6%9C%97%E3%81%AE%E5%81%A5%E3%82%84%E3%81%8B", "promoted_content": null, "query": "%E8%A5%BF%E5%B1%B1%E5%AE%8F%E5%A4%AA%E6%9C%97%E3%81%AE%E5%81%A5%E3%82%84%E3%81%8B", "tweet_volume": null}, {"name": "断固抗議", "url": "http://twitter.com/search?q=%E6%96%AD%E5%9B%BA%E6%8A%97%E8%AD%B0", "promoted_content": null, "query": "%E6%96%AD%E5%9B%BA%E6%8A%97%E8%AD%B0", "tweet_volume": null}, {"name": "前原誠司代表の優柔不断さ", "url": "http://twitter.com/search?q=%E5%89%8D%E5%8E%9F%E8%AA%A0%E5%8F%B8%E4%BB%A3%E8%A1%A8%E3%81%AE%E5%84%AA%E6%9F%94%E4%B8%8D%E6%96%AD%E3%81%95", "promoted_content": null, "query": "%E5%89%8D%E5%8E%9F%E8%AA%A0%E5%8F%B8%E4%BB%A3%E8%A1%A8%E3%81%AE%E5%84%AA%E6%9F%94%E4%B8%8D%E6%96%AD%E3%81%95", "tweet_volume": null}, {"name": "電柱風景の作品投稿", "url": "http://twitter.com/search?q=%E9%9B%BB%E6%9F%B1%E9%A2%A8%E6%99%AF%E3%81%AE%E4%BD%9C%E5%93%81%E6%8A%95%E7%A8%BF", "promoted_content": null, "query": "%E9%9B%BB%E6%9F%B1%E9%A2%A8%E6%99%AF%E3%81%AE%E4%BD%9C%E5%93%81%E6%8A%95%E7%A8%BF", "tweet_volume": null}, {"name": "グラブルコラボ", "url": "http://twitter.com/search?q=%E3%82%B0%E3%83%A9%E3%83%96%E3%83%AB%E3%82%B3%E3%83%A9%E3%83%9C", "promoted_content": null, "query": "%E3%82%B0%E3%83%A9%E3%83%96%E3%83%AB%E3%82%B3%E3%83%A9%E3%83%9C", "tweet_volume": null}, {"name": "遊戯王買取情報", "url": "http://twitter.com/search?q=%E9%81%8A%E6%88%AF%E7%8E%8B%E8%B2%B7%E5%8F%96%E6%83%85%E5%A0%B1", "promoted_content": null, "query": "%E9%81%8A%E6%88%AF%E7%8E%8B%E8%B2%B7%E5%8F%96%E6%83%85%E5%A0%B1", "tweet_volume": null}, {"name": "#pyconjp_201", "url": "http://twitter.com/search?q=%23pyconjp_201", "promoted_content": null, "query": "%23pyconjp_201", "tweet_volume": null}, {"name": "#SFormula", "url": "http://twitter.com/search?q=%23SFormula", "promoted_content": null, "query": "%23SFormula", "tweet_volume": null}, {"name": "#FNOJP", "url": "http://twitter.com/search?q=%23FNOJP", "promoted_content": null, "query": "%23FNOJP", "tweet_volume": null}, {"name": "#fcgifu", "url": "http://twitter.com/search?q=%23fcgifu", "promoted_content": null, "query": "%23fcgifu", "tweet_volume": null}, {"name": "#consadole", "url": "http://twitter.com/search?q=%23consadole", "promoted_content": null, "query": "%23consadole", "tweet_volume": null}, {"name": "#ゆっふぃーバス", "url": "http://twitter.com/search?q=%23%E3%82%86%E3%81%A3%E3%81%B5%E3%81%83%E3%83%BC%E3%83%90%E3%82%B9", "promoted_content": null, "query": "%23%E3%82%86%E3%81%A3%E3%81%B5%E3%81%83%E3%83%BC%E3%83%90%E3%82%B9", "tweet_volume": null}, {"name": "#カーリング", "url": "http://twitter.com/search?q=%23%E3%82%AB%E3%83%BC%E3%83%AA%E3%83%B3%E3%82%B0", "promoted_content": null, "query": "%23%E3%82%AB%E3%83%BC%E3%83%AA%E3%83%B3%E3%82%B0", "tweet_volume": null}, {"name": "#jazug", "url": "http://twitter.com/search?q=%23jazug", "promoted_content": null, "query": "%23jazug", "tweet_volume": null}, {"name": "#un1te_club", "url": "http://twitter.com/search?q=%23un1te_club", "promoted_content": null, "query": "%23un1te_club", "tweet_volume": null}, {"name": "#パワカン", "url": "http://twitter.com/search?q=%23%E3%83%91%E3%83%AF%E3%82%AB%E3%83%B3", "promoted_content": null, "query": "%23%E3%83%91%E3%83%AF%E3%82%AB%E3%83%B3", "tweet_volume": null}, {"name": "#nagoyasec", "url": "http://twitter.com/search?q=%23nagoyasec", "promoted_content": null, "query": "%23nagoyasec", "tweet_volume": null}, {"name": "#リズアニ", "url": "http://twitter.com/search?q=%23%E3%83%AA%E3%82%BA%E3%82%A2%E3%83%8B", "promoted_content": null, "query": "%23%E3%83%AA%E3%82%BA%E3%82%A2%E3%83%8B", "tweet_volume": null}, {"name": "#gsrcup", "url": "http://twitter.com/search?q=%23gsrcup", "promoted_content": null, "query": "%23gsrcup", "tweet_volume": null}, {"name": "#dbkan", "url": "http://twitter.com/search?q=%23dbkan", "promoted_content": null, "query": "%23dbkan", "tweet_volume": null}, {"name": "#ボカフリ", "url": "http://twitter.com/search?q=%23%E3%83%9C%E3%82%AB%E3%83%95%E3%83%AA", "promoted_content": null, "query": "%23%E3%83%9C%E3%82%AB%E3%83%95%E3%83%AA", "tweet_volume": null}, {"name": "#osc17tk", "url": "http://twitter.com/search?q=%23osc17tk", "promoted_content": null, "query": "%23osc17tk", "tweet_volume": null}, {"name": "#カーネル誕生日おめでとう", "url": "http://twitter.com/search?q=%23%E3%82%AB%E3%83%BC%E3%83%8D%E3%83%AB%E8%AA%95%E7%94%9F%E6%97%A5%E3%81%8A%E3%82%81%E3%81%A7%E3%81%A8%E3%81%86", "promoted_content": null, "query": "%23%E3%82%AB%E3%83%BC%E3%83%8D%E3%83%AB%E8%AA%95%E7%94%9F%E6%97%A5%E3%81%8A%E3%82%81%E3%81%A7%E3%81%A8%E3%81%86", "tweet_volume": null}, {"name": "#フェス", "url": "http://twitter.com/search?q=%23%E3%83%95%E3%82%A7%E3%82%B9", "promoted_content": null, "query": "%23%E3%83%95%E3%82%A7%E3%82%B9", "tweet_volume": null}]
}
//list
class TrendsPlace(oauth: OAuthRequestHandler) : AbsOAuthGet<TrendsPlaceModel>(oauth) {
    override val resourceUrl = "https://api.twitter.com/1.1/trends/place.json"
    override val responseFormat = ResponseFormats.JSON
    override val isRateLimited = true
    override val defaultParameter = Parameter()
}
