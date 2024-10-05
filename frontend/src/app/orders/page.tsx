"use client";

import { useEffect, useState } from "react";
import Breadcrumb from "@/components/Breadcrumbs/Breadcrumb";
import DefaultLayout from "@/components/Layouts/DefaultLaout";
import SelectGroupOne from "@/components/SelectGroup/SelectGroupOne";
import { toast } from "react-toastify";
import {
  authenticatedRequest,
  authenticatedRequestManu,
} from "@/utils/axios-util";

const OrdersPage = () => {
  const [reason, setReason] = useState("");
  const [equipmentId, setEquipmentId] = useState(0);
  const [technicianId, setTechnicianId] = useState(0);
  const [equipments, setEquipments] = useState([]);
  const [priority, setPriority] = useState("");
  const [type, setType] = useState("");
  const [technicians, setTechnician] = useState([]);

  useEffect(() => {
    getEquipments();
    getTechnician();
  }, []);

  async function getEquipments() {
    try {
      const res = await authenticatedRequestManu.get(
        `/manufacture-api/equipments`
      );

      setEquipments(res.data.content);
    } catch {
      toast.error("Erro ao buscar equipamentos");
    }
  }

  async function getTechnician() {
    try {
      const res = await authenticatedRequest.get(
        `/maintenance-api/employees/technician`
      );

      setTechnician(res.data);
    } catch {
      toast.error("Erro ao buscar tecnicos");
    }
  }

  async function handleRequest() {
    const requestData = {
      reason,
      equipmentId,
      priority,
      type,
      employeeId: technicianId,
    };

    try {
      await authenticatedRequest.post(
        `/maintenance-api/maintenance-orders`,
        requestData
      );

      toast.success("Sucesso ao reportar problema");
    } catch {
      toast.error("Erro ao reportar problema");
    }
  }

  return (
    <DefaultLayout>
      <Breadcrumb pageName="Chamados de Manutenção" />

      <div className="grid">
        <div className="flex flex-col gap-9">
          {/* <!-- Contact Form --> */}
          <div className="rounded-[10px] border border-stroke bg-white shadow-1 dark:border-dark-3 dark:bg-gray-dark dark:shadow-card">
            <div className="border-b border-stroke px-6.5 py-4 dark:border-dark-3">
              <h3 className="font-semibold text-dark dark:text-white">
                Criar Chamados de Manutenção
              </h3>
            </div>

            <div className="p-6.5">
              <SelectGroupOne
                label="Atribuir a um Técnico"
                callBackValue={(e) => setTechnicianId(e)}
              >
                <option value="" disabled className="text-dark-6">
                  Escolha um técnico
                </option>
                {technicians.length > 0 &&
                  technicians.map((technician: any) => (
                    <option
                      key={`technician${technician.id}`}
                      value={technician.id}
                      className="text-dark-6"
                    >
                      {technician.name}
                    </option>
                  ))}
              </SelectGroupOne>

              <SelectGroupOne
                label="Equipamento"
                callBackValue={(e) => setEquipmentId(Number(e))}
              >
                <option value="" disabled className="text-dark-6">
                  Escolha o equipamento
                </option>

                {equipments.length > 0 &&
                  equipments.map((equipment: any) => (
                    <option
                      key={`equipment${equipment.id}`}
                      value={equipment.id}
                      className="text-dark-6"
                    >
                      {equipment.name}
                    </option>
                  ))}
              </SelectGroupOne>

              <SelectGroupOne
                label="Tipo de manutenção"
                callBackValue={(e) => setType(e)}
              >
                <option value="" disabled className="text-dark-6">
                  Escolha o tipo de manutenção
                </option>
                <option value="PRODUCTION" className="text-dark-6">
                  PRODUÇÃO
                </option>
                <option value="INSPECTION" className="text-dark-6">
                  INSPEÇÃO
                </option>
                <option value="PREVENTIVE" className="text-dark-6">
                  PREVENTIVO
                </option>
                <option value="PREDICTIVE" className="text-dark-6">
                  PREDITIVO
                </option>
                <option value="INCIDENT" className="text-dark-6">
                  INCIDENTE
                </option>
              </SelectGroupOne>

              <SelectGroupOne
                label="Prioridade"
                callBackValue={(e) => setPriority(e)}
              >
                <option value="" disabled className="text-dark-6">
                  Escolha o tipo de Prioridade
                </option>
                <option value="LOW" className="text-dark-6">
                  BAIXA
                </option>
                <option value="MEDIUM" className="text-dark-6">
                  MEDIA
                </option>
                <option value="HIGH" className="text-dark-6">
                  ALTA
                </option>
              </SelectGroupOne>

              <div className="mb-6">
                <label className="mb-3 block text-body-sm font-medium text-dark dark:text-white">
                  Descrição
                </label>
                <textarea
                  onChange={(e) => setReason(e.target.value)}
                  rows={6}
                  placeholder="Type your message"
                  className="w-full rounded-[7px] border-[1.5px] border-stroke bg-transparent px-5 py-3 text-dark outline-none transition placeholder:text-dark-6 focus:border-primary active:border-primary disabled:cursor-default dark:border-dark-3 dark:bg-dark-2 dark:text-white dark:focus:border-primary"
                ></textarea>
              </div>
              <button
                onClick={() => handleRequest()}
                className="flex w-full justify-center rounded-[7px] bg-primary p-[13px] font-medium text-white hover:bg-opacity-90"
              >
                Enviar
              </button>
            </div>
          </div>
        </div>
      </div>
    </DefaultLayout>
  );
};

export default OrdersPage;
