package DataModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class RateDataModel {
    public int rate;
    public String fromCurrency;
    public String toCurrency;
}
