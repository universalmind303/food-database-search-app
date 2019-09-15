import React from 'react';
import { connectProduct } from './ProductConnector';
import { ProductsType, } from './model';
import { ListGroup, Accordion, Card, Table, Container, Row, Col } from 'react-bootstrap';

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
                  eventKey={`${product.productName}`}>
                  {product.productName}
               </Accordion.Toggle>
               <Accordion.Collapse eventKey={`${product.productName}`}>
                  <Card.Body>
                     <Container>
                        <Row>
                           <Col>
                              <Table size="sm">
                                 <thead>
                                    <tr>
                                       <th>Nutritition Info</th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                    {product.nutrientsList.map((nutrient, idx) =>
                                       <tr key={idx}>

                                          <td>{nutrient}</td>
                                       </tr>
                                    )}
                                 </tbody>
                              </Table>
                           </Col>
                           <Col>
                              <Table size="sm">
                                 <thead>
                                    <tr>
                                       <th>Ingredients</th>
                                    </tr>
                                 </thead>
                                 <tbody>
                                    <tr>
                                       <td>{product.ingredients}</td>
                                    </tr>
                                 </tbody>
                              </Table>
                           </Col>
                        </Row>
                     </Container>

                  </Card.Body>
               </Accordion.Collapse>
            </Card>
         )}
      </Accordion>
   )
}


export const Product = connectProduct(ProductBase);
