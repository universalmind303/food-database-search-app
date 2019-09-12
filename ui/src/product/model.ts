
import t from 'tcomb';

export type Product = {
    ndbNumber: number,
    id: number,
    productName: string,
};

export const Product = t.struct({
    ndbNumber: t.String,
    id: t.Number,
    productName: t.String
}, {
    name: 'Product'
});

export type ProductsType = Product[];

export const Products: any = t.list(Product, 'Products');

export const getDefaultProducts = () => new Products([]);
