import React from 'react';
import { connectProduct } from './ProductConnector';
import { ProductsType, } from './model';
import { ListGroup, Accordion, Card } from 'react-bootstrap';
import { Nutrients } from '../nutrients/Nutrients';
import { NutrientsProvider } from '../nutrients/NutrientsProvider';

export type ProductBaseProps = {
   products: ProductsType,
   setNutrientQuery: Function,
};

const ProductBase: React.FC<ProductBaseProps> = (props: ProductBaseProps) => {
   return (
      <Accordion defaultActiveKey="0">
         {props.products.map((product) =>
            <Card key={product.id}>
               <Accordion.Toggle
                  as={Card.Header}
                  onClick={() => props.setNutrientQuery(product.ndbNo)}
                  eventKey={`${product.productName}`}>
                  {product.productName}
               </Accordion.Toggle>
               <Accordion.Collapse eventKey={`${product.productName}`}>
                  <Card.Body>
                     <NutrientsProvider>
                        <Nutrients />
                     </NutrientsProvider>
                  </Card.Body>
               </Accordion.Collapse>
            </Card>
         )}
      </Accordion>
   )
}


export const Product = connectProduct(ProductBase);
