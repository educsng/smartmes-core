import { authenticatedRequest } from "@/utils/axios-util";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";

const TableTwo = () => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    getOrders();
  }, []);

  async function getOrders() {
    try {
      const res = await authenticatedRequest.get(
        `/manufacture-api/manufacture-orders`
      );

      setOrders(res.data.content);
    } catch {
      toast.error("Erro ao buscar ordens");
    }
  }

  return (
    <div className="rounded-[10px] bg-white px-7.5 pb-4 pt-7.5 shadow-1 dark:bg-gray-dark dark:shadow-card">
      <h4 className="mb-5.5 text-body-2xlg font-bold text-dark dark:text-white">
        Ordens de Produção
      </h4>

      <div className="flex flex-col">
        <div className="grid grid-cols-3 sm:grid-cols-3">
          <div className="px-2 pb-3.5 text-left">
            <h5 className="text-sm font-medium uppercase xsm:text-base">
              Numero
            </h5>
          </div>
          <div className="px-2 pb-3.5 text-left">
            <h5 className="text-sm font-medium uppercase xsm:text-base">
              Descrição
            </h5>
          </div>

          <div className="px-2 pb-3.5 text-left">
            <h5 className="text-sm font-medium uppercase xsm:text-base">
              Responsavel
            </h5>
          </div>
        </div>

        {orders.map(({ manufactureOrder: order }: any, key: any) => (
          <div
            className={`grid grid-cols-3 sm:grid-cols-3 ${
              key === orders.length - 1
                ? ""
                : "border-b border-stroke dark:border-dark-3"
            }`}
            key={key}
          >
            <div className="flex items-center gap-3.5 px-2 py-4">
              <p className="hidden font-medium text-dark dark:text-white sm:block">
                {order.orderNumber}
              </p>
            </div>
            <div className="flex items-center gap-3.5 px-2 py-4">
              <p className="hidden font-medium text-dark dark:text-white sm:block">
                {order.description}
              </p>
            </div>
            <div className="flex items-center gap-3.5 px-2 py-4">
              <p className="hidden font-medium text-dark dark:text-white sm:block">
                {order.employee}
              </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default TableTwo;
