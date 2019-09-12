import React, { Fragment } from 'react';
import { connectProductSearch } from './ProductSearchConnector';


export const ProductSearchBase: React.FC = () => < Fragment />


export const ProductSearch = connectProductSearch(ProductSearchBase);