#Spring-boot-homework

使用redis DB

##restful API


+ Request url:
```shell
http://140.123.101.180:8080/search
```

+ Request Parameter:
	+ query   : default value ="*"      //搜尋title的字串
  + offset  : default value = 0       //第幾筆資料開始
  + size    : default value = 5       //需要幾筆資料
```shell
http://140.123.101.180:8080/search?query=歐洲&offset=0&size=5
```

+ Result:
```shell
{"hits":1,"result":["{\"native\":{\"assets\":[{\"id\":1,\"title\":{\"text\":\"我們飛往100+個歐洲城市，是您前往歐洲的最佳選擇\"}},{\"id\":2,\"img\":{\"url\":\"//tenmaximg.cacafly.net/upload/6/8/5/2/c2d2d7e4_icon.jpg?v=1\",\"w\":250,\"h\":250}},{\"id\":3,\"img\":{\"url\":\"//tenmaximg.cacafly.net/upload/6/8/5/2/c2d2d7e4_m.jpg?v=1\",\"w\":574,\"h\":300}},{\"id\":4,\"data\":{\"value\":\"土耳其航空是全球成長最迅速的航空公司，飛航近120個國家/300個城市。土耳其航空亦連續六年榮獲Skytrax「歐洲最佳航空公司」大獎。\"}},{\"id\":5,\"data\":{\"value\":\"土耳其航空\"},\"link\":{\"url\":\"http://www.turkishairlines.com/en-tw/flights-tickets/flights-destinations?departure=taipei&continent=all&class=economy&utm_source=mediamind&utm_campaign=cd-2016/12-taipei-network&utm_medium=CPM&utm_content=THY_Taiwan_Taipei_New_Route_TenMax_Image_text_CPM627X627_network-Banner\",\"clicktrackers\":[]}},{\"id\":6,\"img\":{\"url\":\"//tenmaximg.cacafly.net/upload/6/8/5/2/c2d2d7e4.jpg?v=1\",\"w\":1200,\"h\":627}},{\"id\":7,\"img\":{\"url\":\"//tenmaximg.cacafly.net/upload/6/8/5/2/c2d2d7e4_s.jpg?v=1\",\"w\":287,\"h\":150}},{\"id\":8,\"img\":{\"url\":\"//tenmaximg.cacafly.net/upload/6/8/5/2/c2d2d7e4_icon_l.jpg?v=1\",\"w\":627,\"h\":627}},{\"id\":9,\"img\":{\"url\":\"//tenmaximg.cacafly.net/upload/6/8/5/2/c2d2d7e4_icon_s.jpg?v=1\",\"w\":80,\"h\":80}},{\"id\":10,\"data\":{\"label\":\"ctatext\",\"value\":\"來試試看!\"}}],\"link\":{\"url\":\"https://dev2.tenmax.io/tpe-tenmax4/bid/asiamax/click/1485102009947/a50b0630-e0be-11e6-aefd-895eba82be4f/4734/6852/?sUrl=http%3A%2F%2Fbeta-ssp.tenmax.io%2Fauction%2Fwinner%2Ftracking%2Fclk%3Fb%3Da50b0630-e0be-11e6-aefd-895eba82be4f%26i%3D0%26adurl%3D%26id%3Ddb0efe1b-8522-45f8-a460-86bf42e3e3b8&rUrl=http%3A%2F%2Fwww.turkishairlines.com%2Fen-tw%2Fflights-tickets%2Fflights-destinations%3Fdeparture%3Dtaipei%26continent%3Dall%26class%3Deconomy%26utm_source%3Dmediamind%26utm_campaign%3Dcd-2016%2F12-taipei-network%26utm_medium%3DCPM%26utm_content%3DTHY_Taiwan_Taipei_New_Route_TenMax_Image_text_CPM627X627_network-Banner\",\"clicktrackers\":[]},\"impressionEvent\":[\"//beta-ssp.tenmax.io/supply/tracking/pixel?s=a50b0630-e0be-11e6-aefd-895eba82be4f&r=55ba76bca772421f\",\"//beta-ssp.tenmax.io/auction/winner/tracking/pixel?b=a50b0630-e0be-11e6-aefd-895eba82be4f&i=0&id=db0efe1b-8522-45f8-a460-86bf42e3e3b8\",\"https://dev2.tenmax.io/tpe-tenmax4/bid/asiamax/impreWithPrice/1485102009947/a50b0630-e0be-11e6-aefd-895eba82be4f/4734/6852/bd4b9b7903cf40ce/xlKZhoPR/\"],\"viewEvent\":[\"https://beta-ssp.tenmax.io/auction/winner/tracking/viewed/0/0/a50b0630-e0be-11e6-aefd-895eba82be4f\",\"https://dev2.tenmax.io/tpe-tenmax4/bid/asiamax/viewable/1485102009947/a50b0630-e0be-11e6-aefd-895eba82be4f/4734/6852/bd4b9b7903cf40ce/\"]}}"]}

```
