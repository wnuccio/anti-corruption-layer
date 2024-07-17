package organizemappinglogic.mappingbuilder.domain;

import java.util.List;

public interface BuyerMapper {
    BuyerMapper name(String name);

    BuyerMapper email(String email);

    void books(List<Book> books);
}
