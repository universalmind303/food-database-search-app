import t from "tcomb";

export type Nutrient = {
  ndbNo: number;
  id: number;
  nutrientsList: string[];
  ingredients: string;
};

export const Nutrient = t.struct(
  {
    ndbNo: t.String,
    id: t.Number,
    nutrientsList: t.Array,
    ingredients: t.String
  },
  {
    name: "Nutrient"
  }
);

export const getDefaultNutrient = () =>
  new Nutrient({
    ndbNo: "",
    id: 0,
    nutrientsList: [],
    ingredients: ""
  });
