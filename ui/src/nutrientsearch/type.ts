import * as t from 'tcomb';

export type NutrientQueryType = {
    nutrientNameQuery: string
};

export const NutrientQueryType = t.struct({
    nutrientNameQuery: t.String
}, {
    name: 'NutrientQuery'
});

export const getDefaultNutrientQuery = () => new NutrientQueryType({
    nutrientNameQuery: ''
});
