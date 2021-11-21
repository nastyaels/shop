package com.eliseeva.shop.rest.advice;

import com.eliseeva.shop.goods.CakesService;
import com.eliseeva.shop.rest.controller.CakeController;
import com.eliseeva.shop.rest.dto.Cakes;
import com.eliseeva.shop.rest.dto.InfoAboutCake;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.test.util.AssertionErrors;

import static org.mockito.ArgumentMatchers.any;

public class CakeControllerTest {

//    @Test
//    void testCakes(){
//        Cakes cakes = new Cakes();
////        cakes.setCakeList(Collections.emptyList());
//        CakesService cakesService = Mockito.mock(CakesService.class);
//        Mockito.doReturn(cakes).when(cakesService).getCakes();
//        CakeController cakeController = new CakeController(cakesService);
//        Cakes cakesTest = cakeController.getListOfCakes();//cakes(?)
//        AssertionErrors.assertEquals("",cakesTest,cakes);
//        Mockito.verify(cakesService,Mockito.times(1)).getCakes();
//    }
//
//    @Test
//    void testByIdCakes(){
//        InfoAboutCake infoAboutCake = new InfoAboutCake();
//        CakesService cakesService = Mockito.mock(CakesService.class);
//        Mockito.doReturn(infoAboutCake).when(cakesService).getInfoAboutCake(any());
//        CakeController cakeController = new CakeController(cakesService);
//        InfoAboutCake cakesTest = cakeController.getCakeById(1L);
//        AssertionErrors.assertEquals("",cakesTest,infoAboutCake);
//        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
//        Mockito.verify(cakesService,Mockito.times(1)).getInfoAboutCake(argumentCaptor.capture());
//        AssertionErrors.assertEquals("",argumentCaptor.getValue(),1L);
//    }
}
