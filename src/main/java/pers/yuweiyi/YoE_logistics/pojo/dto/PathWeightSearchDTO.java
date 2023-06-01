package pers.yuweiyi.YoE_logistics.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: PathWeightSearchDTO <br/>
 * description: 路径权重查询传输对象。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 6/1/2023 11:10 AM <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathWeightSearchDTO extends DTO{
    @NotNull private String station_from;
    @NotNull private String station_to;
}
