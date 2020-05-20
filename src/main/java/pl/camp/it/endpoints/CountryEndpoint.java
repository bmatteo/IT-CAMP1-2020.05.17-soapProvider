package pl.camp.it.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.camp.it.countries.Country;
import pl.camp.it.countries.Currency;
import pl.camp.it.countries.GetCountryRequest;
import pl.camp.it.countries.GetCountryResponse;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://it.camp.pl/countries/";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryResponse(@RequestPayload GetCountryRequest getCountryRequest) {
        System.out.println("Działa !!");

        System.out.println(getCountryRequest.getName());

        GetCountryResponse respone = new GetCountryResponse();
        Country country = new Country();
        country.setName("Polska");
        country.setPopulation(40000000);
        country.setCapital("Warszawa");
        country.setCurrency(Currency.PLN);

        respone.setCountry(country);

        return respone;
    }
}
