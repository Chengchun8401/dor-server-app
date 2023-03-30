package com.city.app.utils;

import com.baidu.aip.face.AipFace;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @version v1.0
 * @ClassName: FaceAip
 * @Description: 人脸识别接口
 * @Author: CitySpring
 */
@Component
@Slf4j
public class FaceAipUtils {

    private static final String APP_ID = "31242495";

    private static final String API_KEY = "EfjQ5G2rObwigWihtWoOeGNu";

    private static final String SECRET_KEY = "7EFj8VGAy3rif45Enlk5g3kvpbxHq2Z3";

    private static final String IMAGE_TYPE = "BASE64";

    private static final String GROUP_ID = "user_face_id_8409";

    private AipFace client;

    private HashMap<String, Object> searchInfo = new HashMap<>();

    private HashMap<String, String> normalInfo = new HashMap<>();

    private FaceAipUtils() {
        //图片质量控制 NONE: 不进行控制 LOW:较低的质量要求 NORMAL: 一般的质量要求 HIGH: 较高的质量要求 默认 NONE
        normalInfo.put("quality_control", "NORMAL");
        normalInfo.put("liveness_control","LOW"); // 活体检测
        searchInfo.put("quality_control", "NORMAL");
        searchInfo.put("liveness_control","LOW");
    }

    /**
     * 单例注入
     */
    @PostConstruct
    public void init() {
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    }

    /**
     * 用户照片存入人脸库中
     */
    public Boolean faceRegister(String userId, String image) {
        JSONObject res = client.addUser(image, IMAGE_TYPE, GROUP_ID, userId, normalInfo);
        log.info("addUser result ：{}", res);
        Integer errorCode = res.getInt("error_code");
        return errorCode == 0;
    }

    /**
     * 更新人脸库中的用户照片
     */
    public Boolean faceUpdate(String userId, String image) {
        JSONObject res = client.updateUser(image, IMAGE_TYPE, GROUP_ID, userId, normalInfo);
        log.info("updateUser result ：{}", res);
        Integer errorCode = res.getInt("error_code");
        return errorCode == 0;
    }

    /**
     * 删除人脸照片
     */
    public Boolean faceDelete(String userId){
        JSONObject res = client.deleteUser(GROUP_ID, userId, normalInfo);
        log.info("deleteUser result ：{}", res);
        Integer errorCode = res.getInt("error_code");
        return errorCode == 0;
    }

    /**
     * 1.搜索人脸库中相似的人脸并返回数据
     *
     * 2.判断人脸匹配得分（score）大于80分则认为是同一个人
     */
    public String faceSearch(String image) {
        JSONObject res = client.search(image, IMAGE_TYPE, GROUP_ID, searchInfo);
        log.info("search result ：{}", res);
        if (res.has("error_code") && res.getInt("error_code") == 0) {
            JSONObject result = res.getJSONObject("result");
            JSONArray userList = result.getJSONArray("user_list");
            if (userList.length() > 0) {
                JSONObject user = userList.getJSONObject(0);
                double score = user.getDouble("score");
                if (score > 80) {
                    return user.getString("user_id");
                }
            }
        }
        return null;
    }


}
