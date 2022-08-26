package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        String geoIP = new GeoIPService().getGeoIPServiceSoap().getIpLocation("46.138.57.225");
    }
}
