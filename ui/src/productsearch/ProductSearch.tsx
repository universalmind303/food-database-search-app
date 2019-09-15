import React from 'react';
import { FormControl, InputGroup } from 'react-bootstrap';
import { connectProductSearch } from './ProductSearchConnector';

export type ProductSearchBaseProps = {
    productNameQuery: string,
    setProductQuery: Function
 };
 
export const ProductSearchBase: React.FC<ProductSearchBaseProps> = (props: ProductSearchBaseProps) => <div>
  <InputGroup className="mb-3">
    <FormControl
      placeholder="Search"
      aria-label="Search"
      aria-describedby="Search"
      onChange={(event: any) => { props.setProductQuery(event.target.value)} }
    />
  </InputGroup>
    
    </div>


export const ProductSearch = connectProductSearch(ProductSearchBase);