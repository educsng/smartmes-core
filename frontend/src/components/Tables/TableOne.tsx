import { authenticatedRequest } from "@/utils/axios-util";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";

const TableOne = () => {
  const [equipments, setEquipments] = useState([]);

  useEffect(() => {
    getEquipments();
  }, []);

  async function getEquipments() {
    try {
      const res = await authenticatedRequest.get(`/manufacture-api/equipments`);

      setEquipments(res.data.content);
    } catch {
      toast.error("Erro ao buscar equipamentos");
    }
  }

  return (
    <div className="rounded-[10px] bg-white px-7.5 pb-4 pt-7.5 shadow-1 dark:bg-gray-dark dark:shadow-card">
      <h4 className="mb-5.5 text-body-2xlg font-bold text-dark dark:text-white">
        Listagem de Máquinas
      </h4>

      <div className="flex flex-col">
        <div className="grid grid-cols-3 sm:grid-cols-5">
          <div className="px-2 pb-3.5">
            <h5 className="text-sm font-medium uppercase xsm:text-base">id</h5>
          </div>
          <div className="px-2 pb-3.5">
            <h5 className="text-sm font-medium uppercase xsm:text-base">
              Nome
            </h5>
          </div>
        </div>

        {equipments.map((equipment, key) => (
          <div
            className={`grid grid-cols-3 sm:grid-cols-5 ${
              key === equipments.length - 1
                ? ""
                : "border-b border-stroke dark:border-dark-3"
            }`}
            key={key}
          >
            <div className="flex items-center gap-3.5 px-2 py-4">
              <p className="hidden font-medium text-dark dark:text-white sm:block">
                {equipment.id}
              </p>
            </div>
            <div className="flex items-center gap-3.5 px-2 py-4">
              <p className="hidden font-medium text-dark dark:text-white sm:block">
                {equipment.name}
              </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default TableOne;
