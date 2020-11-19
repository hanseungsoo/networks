package io.human.networks.service.vo;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Data
public class CompanyVo {

    private String resultCode;
    private String resultMsg;
    private String numOfRows;
    private String pageNo;
    private String totalCount;

    private List<CompanyItem> companyItems;

    public CompanyVo toCompanyVo(String body) {
        JSONObject jsonObject = new JSONObject(body);
        CompanyVo companyVo = new CompanyVo();
        JSONObject responseObject = jsonObject.getJSONObject("response");
        JSONObject hObject = responseObject.getJSONObject("header");
        companyVo.setResultCode(hObject.getString("resultCode"));
        companyVo.setResultMsg(hObject.getString("resultMsg"));

        JSONObject bObject = responseObject.getJSONObject("body");

        companyVo.setNumOfRows(bObject.getString("numOfRows"));
        companyVo.setPageNo(bObject.getString("pageNo"));
        companyVo.setTotalCount(bObject.getString("totalCount"));

        JSONArray itemArray = bObject.getJSONObject("items").getJSONArray("item");
        List<CompanyItem> companyItems = new ArrayList<>();

        for (int i = 0; i < itemArray.length(); i++) {
            JSONObject itemObject = itemArray.getJSONObject(i);
            CompanyItem companyItem = new CompanyItem();
            companyItem.setBasDt(itemObject.getString("basDt"));
            companyItem.setCrno(itemObject.getString("crno"));
            companyItem.setCorpNm(itemObject.getString("corpNm"));
            companyItem.setCorpEnsnNm(itemObject.getString("corpEnsnNm"));
            companyItem.setEnpBsadr(itemObject.getString("enpBsadr"));
            companyItem.setEnpDtadr(itemObject.getString("enpDtadr"));
            companyItem.setEnpHmpgUrl(itemObject.getString("enpHmpgUrl"));
            companyItem.setEnpTlno(itemObject.getString("enpTlno"));

            companyItems.add(companyItem);
        }
        companyVo.setCompanyItems(companyItems);

        return null;
    }
}
