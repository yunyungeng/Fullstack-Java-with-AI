import { useEffect, useMemo, useState } from 'react'
import Layout from './components/Layout.jsx'
import SummaryCard from './components/SummaryCard.jsx'
import { sampleAssets } from './data/sampleAssets.js'
import { filterAssets } from './utils/assets.js'
import './styles.css'

export default function App() {
  const [assets] = useState(sampleAssets) 
  const [selectedAsset, setSelectedAsset] = useState(sampleAssets[0])

  const filteredAssets = useMemo(
    () => filterAssets(assets, searchText, statusFilter),
    [assets, searchText, statusFilter]
  );

  return (
    <Layout>
      <SummaryCard assets={filteredAssets} />

      <FilterPanel
        searchText={searchText}
        statusFilter={statusFilter}
        onSearchText={setSearchText}
        onStatusChange={setStatusFilter}
      />

      <section className="workspace-grid">
        <AssetList
          assets={filteredAssets}
          selectedAsset={selectedAsset}
          onSelectAsset={setSelectedAsset}
        />
        <AssetDetails asset={selectedAsset} />
      </section>
    </Layout>
  )
}