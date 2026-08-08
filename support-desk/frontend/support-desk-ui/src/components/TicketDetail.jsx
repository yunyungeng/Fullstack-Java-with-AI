import StatusBadge from './StatusBadge.jsx';
import PriorityBadge from './PriorityBadge.jsx';

export default function TicketDetail({ ticket }) {
  if (!ticket) {
    return <div className="empty-state">Select a ticket to view more information.</div>;
  }

  return (
    <section className="card detail-card">
      <div className="section-heading row-heading">
        <div>
          <h2>{ticket.title}</h2>
          <p>{ticket.category}</p>
        </div>
        <StatusBadge status={ticket.status} />
      </div>

      <dl className="detail-list">
        <div>
          <dt>Priority</dt>
          <dd><PriorityBadge priority={ticket.priority} /></dd>
        </div>
        <div>
          <dt>Status</dt>
          <dd>{ticket.status}</dd>
        </div>
        <div>
          <dt>Created By</dt>
          <dd>{ticket.createdBy}</dd>
        </div>
        <div>
          <dt>Created At</dt>
          <dd>{ticket.createdAt}</dd>
        </div>
      </dl>
    </section>
  );
}