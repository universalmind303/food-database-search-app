
import * as t from 'tcomb';
import { Products } from './product/model';
import { ProductQueryType } from './productsearch/type';

export const State = t.struct({
    products: Products,
    productQuery: ProductQueryType
}, {
    name: 'State'
});
