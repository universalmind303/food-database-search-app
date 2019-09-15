import t from "tcomb";

export type Product = {
  id: number;
  productName: string;
  nutrientsList: string[]
  ingredients: string
};

export const Product = t.struct(
  {
    id: t.Number,
    productName: t.String,
    nutrientsList: t.Array,
    ingredients: t.String
  },
  {
    name: "Product"
  }
);

export type ProductsType = Product[];

export const Products: any = t.list(Product, "Products");

export const getDefaultProducts = () => new Products([]);
