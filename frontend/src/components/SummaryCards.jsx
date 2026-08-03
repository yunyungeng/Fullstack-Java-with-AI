import { CountByStatus } from "../utils/assets.js";

export default function SummaryCards({ assets }) {
    const total = assets.length;
    const available = CountByStatus(assets, 'AVAILABLE');
    const assigned = CountByStatus(assets, 'ASSIGNED');
    const maintenance = CountByStatus(assets, 'MAINTENANCE');

    return (
        <section className="summary-grid" aria-label="Asset Summary">
            <SummaryCards label="Total Assets" count={total} />
            <SummaryCards label="Available" count={available} />
            <SummaryCards label="Assigned" count={assigned} />
            <SummaryCards label="Maintenance" count={maintenance} />
        </section>
    );
}

function SummaryCard({ label, value }) {
    return (
        <div className="summary-card">
            <p>{label}</p>
            <strong>{value}</strong>
        </div>
    );
}