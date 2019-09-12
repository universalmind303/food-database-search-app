import * as t from 'tcomb';

export type ProductQueryType = {
    productNameQuery: string
};

export const ProductQueryType = t.struct({
    productNameQuery: t.String
}, {
    name: 'ProductQuery'
});

export const getDefaultProductQuery = () => new ProductQueryType({
    productNameQuery: ''
});
