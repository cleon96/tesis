package uci.tesis.carlostesis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilterConnector {
    private String info;
    private String vendorId;
    private String vendorErrorCode;
}
