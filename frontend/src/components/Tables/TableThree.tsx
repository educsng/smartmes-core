"use client";

import { authenticatedRequest } from "@/utils/axios-util";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import SelectGroupOne from "@/components/SelectGroup/SelectGroupOne";

const packageDataMock = [
  {
    id: 1,
    reason: "Apresenta falhas",
    createdAt: "Jan 13,2023",
    equipment: "Torno",
    orderStatus: "CREATED",
    type: "Free",
  },
  {
    id: 2,
    reason: "Apresenta falhas 2",
    createdAt: "Jan 13,2023",
    equipment: "Torno 2",
    orderStatus: "IN_PROGRESS",
    type: "Free 2",
  },
  {
    id: 3,
    reason: "Apresenta falhas 3",
    createdAt: "Jan 13,2023",
    equipment: "Torno 3",
    orderStatus: "FINISHED",
    type: "Free 3",
  },
];

const TableThree = () => {
  const [packageData, setData] = useState<any>([]);
  const [loading, setLoading] = useState(false);

  async function handleRequest() {
    setLoading(true);

    try {
      const res = await authenticatedRequest.get(
        `/maintenance-api/maintenance-orders`
      );

      setData(res.data.content);
    } catch {
      setData(packageDataMock);
      toast.error("Erro ao buscar dados");
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    handleRequest();
  }, []);

  const updateStatus = async (status: string, dataRes: any) => {
    try {
      await authenticatedRequest.put(
        `/maintenance-api/maintenance-orders/${dataRes.id}`,
        {
          orderStatus: status,
          items: [
            {
              description: "Teste update",
              employeeId: 1,
              shift: "MORNING",
            },
          ],
        }
      );

      toast.success("Status atualizado com sucesso");
    } catch {
      toast.error("Erro ao atualizar status");
    } finally {
      handleRequest();
    }
  };

  return loading ? (
    <>loading</>
  ) : (
    <div className="rounded-[10px] border border-stroke bg-white p-4 shadow-1 dark:border-dark-3 dark:bg-gray-dark dark:shadow-card sm:p-7.5">
      <div className="max-w-full overflow-x-auto">
        <table className="w-full table-auto">
          <thead>
            <tr className="bg-[#F7F9FC] text-left dark:bg-dark-2">
              <th className="px-4 py-4 font-medium text-dark dark:text-white xl:pr-7.5">
                ID
              </th>
              <th className="px-4 py-4 text-left font-medium text-dark dark:text-white xl:pr-7.5">
                Motivo
              </th>

              <th className="px-4 py-4 text-left font-medium text-dark dark:text-white xl:pr-7.5">
                Tipo
              </th>
              <th className="min-w-[120px] px-4 py-4 font-medium text-dark dark:text-white">
                Equipamento
              </th>
              <th className="px-4 py-4 text-left font-medium text-dark dark:text-white xl:pr-7.5">
                Status
              </th>
              <th className="min-w-[150px] px-4 py-4 font-medium text-dark dark:text-white">
                Criado em
              </th>
              <th className="min-w-[150px] px-4 py-4 font-medium text-dark dark:text-white">
                Atualizar Status
              </th>
            </tr>
          </thead>
          <tbody>
            {packageData.length > 0 &&
              packageData.map((packageItem, index) => (
                <tr key={index}>
                  <td
                    className={`border-[#eee] px-4 py-4 dark:border-dark-3 ${
                      index === packageData.length - 1
                        ? "border-b-0"
                        : "border-b"
                    }`}
                  >
                    <p className="text-dark dark:text-white">
                      {packageItem.id}
                    </p>
                  </td>
                  <td
                    className={`border-[#eee] px-4 py-4 dark:border-dark-3 ${
                      index === packageData.length - 1
                        ? "border-b-0"
                        : "border-b"
                    }`}
                  >
                    <p className="text-dark dark:text-white">
                      {packageItem.reason}
                    </p>
                  </td>
                  <td
                    className={`border-[#eee] px-4 py-4 dark:border-dark-3 ${
                      index === packageData.length - 1
                        ? "border-b-0"
                        : "border-b"
                    }`}
                  >
                    <p className="text-dark dark:text-white">
                      {packageItem.type}
                    </p>
                  </td>
                  <td
                    className={`border-[#eee] px-4 py-4 dark:border-dark-3 ${
                      index === packageData.length - 1
                        ? "border-b-0"
                        : "border-b"
                    }`}
                  >
                    <p className="text-dark dark:text-white">
                      {packageItem.equipment}
                    </p>
                  </td>
                  <td
                    className={`border-[#eee] px-4 py-4 dark:border-dark-3 ${
                      index === packageData.length - 1
                        ? "border-b-0"
                        : "border-b"
                    }`}
                  >
                    <p
                      className={`inline-flex rounded-full px-3.5 py-1 text-body-sm font-medium ${
                        packageItem.orderStatus === "FINISHED"
                          ? "bg-[#219653]/[0.08] text-[#219653]"
                          : packageItem.orderStatus === "CREATED"
                          ? "bg-[#D34053]/[0.08] text-[#D34053]"
                          : "bg-[#FFA70B]/[0.08] text-[#FFA70B]"
                      }`}
                    >
                      {packageItem.orderStatus}
                    </p>
                  </td>

                  <td
                    className={`border-[#eee] px-4 py-4 dark:border-dark-3 ${
                      index === packageData.length - 1
                        ? "border-b-0"
                        : "border-b"
                    }`}
                  >
                    <p className="text-dark dark:text-white">
                      {packageItem.createdAt}
                    </p>
                  </td>
                  <td
                    className={`border-[#eee] px-4 py-4 dark:border-dark-3 ${
                      index === packageData.length - 1
                        ? "border-b-0"
                        : "border-b"
                    }`}
                  >
                    <p className="text-dark dark:text-white">
                      {packageItem.orderStatus !== "FINISHED" && (
                        <SelectGroupOne
                          label="Novo status"
                          callBackValue={(e) => updateStatus(e, packageItem)}
                        >
                          <option value="" disabled className="text-dark-6">
                            Novo status
                          </option>

                          <option value="IN_PROGRESS" className="text-dark-6">
                            Em progresso
                          </option>
                          <option value="FINISHED" className="text-dark-6">
                            Finalizado
                          </option>
                        </SelectGroupOne>
                      )}
                    </p>
                  </td>
                </tr>
              ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default TableThree;
