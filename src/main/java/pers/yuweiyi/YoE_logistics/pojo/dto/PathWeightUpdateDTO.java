package pers.yuweiyi.YoE_logistics.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: PathWeightUpdateDTO <br/>
 * description: 路径权重更新传输对象。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/25/2023 11:28 PM <br/>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathWeightUpdateDTO extends DTO{
    @NotNull private String station_from;
    @NotNull private String station_to;
    @NotNull private String new_weight;

    public PathWeightUpdateDTO(String pathSourceStationName, String pathTargetStationName, int newWeight) {
        this.station_from = pathSourceStationName;
        this.station_to = pathTargetStationName;
        this.new_weight = String.valueOf(newWeight);
    }
}
