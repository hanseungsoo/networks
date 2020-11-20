package io.human.networks.vo;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Data
public class SchoolVo {

    private String listTotalCount;
    private String code;
    private String message;

    private List<SchoolItem> schoolItems;


    public SchoolVo toSchoolVo(String body) {
        JSONObject jsonObject = new JSONObject(body);
        JSONArray jsonArray = jsonObject.getJSONArray("schoolInfo");
        JSONArray hArray = jsonArray.getJSONObject(0).getJSONArray("head");
        JSONArray bArray = jsonArray.getJSONObject(1).getJSONArray("row");
        JSONObject resultObject = hArray.getJSONObject(1).getJSONObject("RESULT");


        SchoolVo schoolVo = new SchoolVo();
        schoolVo.setListTotalCount(hArray.getJSONObject(0).getString("list_total_count"));


        schoolVo.setCode(resultObject.getString("CODE"));
        schoolVo.setMessage(resultObject.getString("MESSAGE"));

        List<SchoolItem> schoolItems = new ArrayList<>();
        for (int i = 0; i < bArray.length(); i++) {
            SchoolItem schoolItem = new SchoolItem();

            JSONObject row = bArray.getJSONObject(i);
            schoolItem.setAtptOfcdcScCode(row.getString("ATPT_OFCDC_SC_CODE"));
            schoolItem.setAtptOfcdcScNm(row.getString("ATPT_OFCDC_SC_NM"));
            schoolItem.setSdSchulCode(row.getString("SD_SCHUL_CODE"));
            schoolItem.setSchulNm(row.getString("SCHUL_NM"));
            schoolItem.setEngSchulNm(row.getString("ENG_SCHUL_NM"));
            schoolItem.setSchulKndScNm(row.getString("SCHUL_KND_SC_NM"));
            schoolItem.setLctnScNm(row.getString("LCTN_SC_NM"));
            schoolItem.setJuOrgNm(row.getString("JU_ORG_NM"));
            schoolItem.setFondScNm(row.getString("FOND_SC_NM"));
            schoolItem.setOrgRdnzc(row.getString("ORG_RDNZC"));
            schoolItem.setOrgRdnma(row.getString("ORG_RDNMA"));
            schoolItem.setOrgRdnda(row.getString("ORG_RDNDA"));
            schoolItem.setOrgTelno(row.getString("ORG_TELNO"));
            schoolItem.setHmpgAdres(row.getString("HMPG_ADRES"));
            schoolItem.setCoeduScNm(row.getString("COEDU_SC_NM"));
            schoolItem.setOrgFaxno(row.getString("ORG_FAXNO"));
            schoolItem.setHsScNm(row.getString("HS_SC_NM"));
            schoolItem.setIndstSpeclCccclExstYn(row.getString("INDST_SPECL_CCCCL_EXST_YN"));
            schoolItem.setHsGnrlBusnsScNm(row.getString("HS_GNRL_BUSNS_SC_NM"));
            schoolItem.setSpclyPurpsHsOrdNm(row.getString("SPCLY_PURPS_HS_ORD_NM"));
            schoolItem.setEneBfeSehfScNm(row.getString("ENE_BFE_SEHF_SC_NM"));
            schoolItem.setDghtScNm(row.getString("DGHT_SC_NM"));
            schoolItem.setFondYmd(row.getString("FOND_YMD"));
            schoolItem.setFoasMemrd(row.getString("FOAS_MEMRD"));
            schoolItem.setLoadDtm(row.getString("LOAD_DTM"));

            schoolItems.add(schoolItem);
        }
        schoolVo.setSchoolItems(schoolItems);

        return schoolVo;
    }
}
