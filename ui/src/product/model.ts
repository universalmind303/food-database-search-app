import t from "tcomb";

export type Product = {
  ndbNo: number;
  id: number;
  productName: string;
};

export const Product = t.struct(
  {
    ndbNo: t.String,
    id: t.Number,
    productName: t.String
  },
  {
    name: "Product"
  }
);

export type ProductsType = Product[];

export const Products: any = t.list(Product, "Products");

export const getDefaultProducts = () => new Products([]);
