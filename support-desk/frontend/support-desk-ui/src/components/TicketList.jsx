import StatusBadge from './StatusBadge.jsx';
import PriorityBadge from './PriorityBadge.jsx';

export default function TicketList({ tickets, selectedTicketId, onSelectTicket }) {
  if (tickets.length === 0) {
    return <div className="empty-state">No tickets to show.</div>;
  }

  return (
    <section className="card list-card">
      <div className="section-heading">
        <h2>Ticket List</h2>
        <p>Select a ticket to view details.</p>
      </div>

      <div className="asset-list">
        {tickets.map((ticket) => (
          <button
            key={ticket.id}
            className={ticket.id === selectedTicketId ? 'asset-row selected' : 'asset-row'}
            onClick={() => onSelectTicket(ticket)}
            type="button"
          >
            <div>
              <strong>{ticket.title}</strong>
              <span>{ticket.category}</span>
            </div>
            <div className="row-badges">
              <PriorityBadge priority={ticket.priority} />
              <StatusBadge status={ticket.status} />
            </div>
          </button>
        ))}
      </div>
    </section>
  );
}