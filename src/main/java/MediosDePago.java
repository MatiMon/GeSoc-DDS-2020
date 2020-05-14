import java.math.BigDecimal;

public interface MediosDePago {
    boolean puedePagarse(BigDecimal cantidad, java.util.Date fecha);
}
