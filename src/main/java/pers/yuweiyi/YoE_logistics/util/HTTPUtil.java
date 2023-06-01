package pers.yuweiyi.YoE_logistics.util;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;
import pers.yuweiyi.YoE_logistics.pojo.dto.DTO;
import pers.yuweiyi.YoE_logistics.pojo.dto.PathWeightUpdateDTO;

import java.io.IOException;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: HTTPUtil <br/>
 * description: HTTP工具。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/31/2023 2:25 PM <br/>
 */
@Component
@Slf4j
public class HTTPUtil {
    public static String serverURL = "http://127.0.0.1:8080/YoE";

    public static OkHttpClient okHttpClient = new OkHttpClient();

    public Response post(String partURL, DTO dto){
        String dtoJSON = JSON.toJSONString(dto);
        RequestBody requestBody = RequestBody.create(
                dtoJSON,
                MediaType.parse("application/json")
        );
        Request request = new Request.Builder()
                .url(HTTPUtil.serverURL + partURL)
                .post(requestBody)
                .build();
        try {
            log.info("HTTP POST Request of [" + partURL + "]");
            Response response = HTTPUtil.okHttpClient.newCall(request).execute();
            return response;
        } catch (IOException e) {
            log.debug("HTTP POST Request of [" + partURL + "]: Failed");
            return null;
        }
    }
}
