import React from 'react';
import './App.css';
import { ProductsProvider } from './product/ProductsProvider';
import { Product } from './product/Product';
import { ProductSearch } from './productsearch/ProductSearch';

const App: React.FC = () => {
  return (
    <div className="App">
      <ProductSearch />
      <ProductsProvider>
        <Product />
      </ProductsProvider>
    </div>
  );
}

export default App;
