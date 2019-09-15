package org.example.foodsearch.demo.products;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.example.foodsearch.demo.products.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {

    private static final String ENDPOINT = "/api/products";

    
    @MockBean
    private ProductService mockProductService;
    
    @Autowired
    private MockMvc mockMvc;
       
    @Test
    public void testGetProducts() throws Exception {
        
        //given

        Long id1 = 8888888888L;
        String productName = "some good pizza";
        String ingredients = "ingredients";
        String[] nutrientsList = (String[])Stream.of("ingredient1", "ingredient2").collect(Collectors.toList()).toArray(new String[0]);
        Product product1 = new Product(id1, productName, ingredients, nutrientsList);
        Collection<Product> products = Stream.of(product1).collect(Collectors.toList());

        //when
        when(mockProductService.getProducts(any())).thenReturn(products);
        //then
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT + "?queryString=pizza")).andDo(print())
            .andExpect(status().isOk())
            // .andReturn().getResponse().getContentAsString();
            .andExpect(jsonPath("$[0].productName").value(productName))
            .andExpect(jsonPath("$[0].ingredients").value(ingredients))
            .andExpect(jsonPath("$[0].id").value(id1.toString()))
            .andExpect(jsonPath("$[0].nutrientsList[0]").value(nutrientsList[0]));

        verify(mockProductService, times(1)).getProducts(any());
    }
  
}
