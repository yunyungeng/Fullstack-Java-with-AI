import { useEffect, useMemo, useState } from 'react'
import Layout from './components/Layout.jsx'
import SummaryCard from './components/SummaryCard.jsx'
import FilterPanel from './components/FilterPanel.jsx'
import AssetList from './components/AssetList.jsx'
import AssetDetails from './components/AssetDetails.jsx'
import ApiInfoCard from './components/ApiInfoCard.jsx'
import { sampleAssets } from './data/sampleAssets.js'
import  { fetchApiInfo, fetchApiDocs } from './utils/api.js'
import { filterAssets } from './utils/assets.js'
import './styles.css'

export default function App() {
  const [assets] = useState(sampleAssets) 
  const [selectedAsset, setSelectedAsset] = useState(sampleAssets[0])
  const [searchText, setSearchText] = useState('')
  const [statusFilter, setStatusFilter] = useState('ALL')
  const [apiInfo, setApiInfo] = useState(null)
  const [apiDocs, setApiDocs] = useState(null)
  const [loadingApi, setLoadingApi] = useState(true)
  const [apiError, setApiError] = useState('')

  const filteredAssets = useMemo(
    () => filterAssets(assets, searchText, statusFilter),
    [assets, searchText, statusFilter]
  );

  useEffect(() => {
    let ignore = false;

    async function loadApiInformation() {
      try {
        setLoadingApi(true);
        setApiError('');

        const [info, docs] = await Promise.all([
          fetchApiInfo(), 
          fetchApiDocs()
        ]);

        if (!ignore) {
          setApiInfo(info);
          setApiDocs(docs);
        }
      } catch (error) {
        if (!ignore) {
          setApiError('Could not connect to backend. Start Spring Boot on port 8080 and try again.');
          console.error(error);
        }
      } finally {
        if (!ignore) {
          setLoadingApi(false);
        }
      }
    }
    loadApiInformation();

    return () => {
      ignore = true;
    };
  }, [])

  useEffect(() => {
    if (filteredAssets.length > 0) {
      setSelectedAsset(null);
      return;
    }

    const selectedStilVisible = filteredAssets.some(asset => asset.id === selectedAsset?.id);

    if (!selectedStilVisible) {
      setSelectedAsset(filteredAssets[0]);
    }
  }, [filteredAssets, selectedAsset]);

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